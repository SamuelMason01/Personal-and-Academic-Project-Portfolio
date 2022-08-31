using System;
using System.Threading;
using System.Windows.Forms;
using System.Linq;

namespace Election
{
    /// <summary>
    /// Public partial class Form Based UI
    /// </summary>
    public partial class FormsBasedUI : Form, IUserInterface // inheriting from other created classes
    {

        // variables
        public ILocationFileReader IOhandler { get; }
        private ConfigData configData;
        private LocationList locationlist;

        // Constructor with params
        public FormsBasedUI(ILocationFileReader IOhandler)
        {
            InitializeComponent();
            this.IOhandler = IOhandler;
        }

        // Private method: Form loads : NEED TO USE
        private void FormsBasedUI_Load(object sender, EventArgs e)
        {
        }

        // Public method Setupconfigdata
        public void SetupConfigData()
        {
            // Make sure configData is a new empty object
            configData = new ConfigData();

            // Generate configuration data using filename for each constituency XML file - note: the actual
            // XML files must be located in the bin/Debug folder of the project (so they can be found)
            configData.configRecords.Add(new ConfigRecord("particulates-01.xml"));
            configData.configRecords.Add(new ConfigRecord("particulates-02.xml"));
            configData.configRecords.Add(new ConfigRecord("particulates-03.xml"));
            configData.configRecords.Add(new ConfigRecord("particulates-04.xml"));
            configData.configRecords.Add(new ConfigRecord("particulates-05.xml"));
            configData.configRecords.Add(new ConfigRecord("particulates-06.xml"));
        }

        // Public method Runproducerconsumer
        public void RunProducerConsumer()
        {
            //Create constituency list to hold individual Constituency objects read from XML files
            locationlist = new LocationList();

            // Create progress manager with number of files to process
            var progManager = new ProgressManager(configData.configRecords.Count);

            // Create a PCQueue instance, give it a capacity of 4
            var pcQueue = new PCQueue(4);

            // Create 2 Producer instances and 2 Consumer instances, these will begin executing on
            // their respective threads as soon as they are instantiated
            Producer[] producers = { new Producer("P1", pcQueue, configData, IOhandler),
                                     new Producer("P2", pcQueue, configData, IOhandler) };

            Consumer[] consumers = { new Consumer("C1", pcQueue, locationlist, progManager),
                                     new Consumer("C2", pcQueue, locationlist, progManager) };

            // Keep producing and consuming until all work items are completed
            while (progManager.ItemsRemaining > 0) ;

            // Deactivate the PCQueue so it does not prevent waiting producer and/or consumer threads
            // from completing
            pcQueue.Active = false;

            // Iterate through consumers and signal them to finish
            foreach (var c in consumers)
            {
                c.Finished = true;
            }

            // Wait for all consumers to finish
            while (Consumer.RunningThreads > 0)
            {
                lock (pcQueue)
                {
                    // Pulse the PCQueue to signal any waiting threads
                    Monitor.Pulse(pcQueue);
                }
            }

            // Iterate through producers and signal them to finish
            foreach (var p in producers)
            {
                p.Finished = true;
            }

            // Wait for all producers to finish
            while (Producer.RunningThreads > 0)
            {
                lock (pcQueue)
                {
                    // Pulse the PCQueue to signal any waiting threads
                    Monitor.Pulse(pcQueue);
                }
            }
        }

        // Private method Config button click
        private void configBtn_Click(object sender, EventArgs e)
        {
            // Clear any items in listbox
            LocationListbox.Items.Clear();

            SetupConfigData();

            // Update form object properties
            progressLbl.Text = "Config data loaded. Waiting for user to press load";
            RunProducerConsumerBtn.Enabled = true;
            configBtn.Enabled = false;
        }

        // Private method Run Producer Consumer button click
        private void RunProducerConsumerBtn_Click(object sender, EventArgs e)
        {
            // Clear any items in listbox
            LocationListbox.Items.Clear();

            progressLbl.Text = "Running producer/consumer queue...";
            progressLbl.Refresh();

            // Run producer/consumer queue to load constituency data
            RunProducerConsumer();

            // Update form object properties
            progressLbl.Text = "Candidate data loaded";
            RunProducerConsumerBtn.Enabled = false;
        }

        // Public Mehtod Display total: FUNCTIONALITY
        public bool Displaytotal()
        {
            // sorting listbox and label items
            DataListbox.Items.Clear();
            label2.Text = "Total particulates across all cities:";
            LocationListbox.Items.Clear();
            DataListbox.Hide();
            label3.Hide();

            // orders the list in alphabeticle order
            var sortedList = locationlist.CalculateParticulatelocationlist().OrderBy(x => x).ToList();

            // Having finished generating data we can now display data on form
            foreach (var c in sortedList)
            {
                LocationListbox.Items.Add(c);
            }    

            return true;
        }

        // Public method Display date total: FUNCTIONALITY
        public bool Displaydatetotal()
        {
            // sorting listbox and label items
            DataListbox.Items.Clear();
            label2.Text = "Total particulates across all dates recorded:";
            LocationListbox.Items.Clear();
            DataListbox.Hide();
            label3.Hide();

            // Having finished generating data we can now display data on form
            foreach (var c in locationlist.CalculateParticulatedatelist())
            {
                LocationListbox.Items.Add(c);
            }

            return true;
        }

        // Public method Display locations: FUNCTIONALITY
        public bool DisplayLocations()
        {
            // sorting listbox and label items
            DataListbox.Show();
            label3.Show();
            LocationListbox.Items.Clear();
            DataListbox.Items.Clear();
            label2.Text = "Locations:";
            label3.Text = "Readings:";

            // orders the list in alphabeticle order
            locationlist.Locations.Sort((x, y) => string.Compare(x.Name, y.Name));

            // Having finished generating data we can now display data on form
            foreach (var c in locationlist.Locations)
            {
                LocationListbox.Items.Add(c);
            }        

            return true;
        }

        // Public method Display highest reading: FUNCTIONALITY
        public bool DisplayHighestReading()
        {
            // sorting listbox and label items
            DataListbox.Items.Clear();
            label2.Text = "Largest particulates across all dates recorded:";
            LocationListbox.Items.Clear();
            DataListbox.Hide();
            label3.Hide();

            // Having finished generating data we can now display data on form
            LocationListbox.Items.Add(locationlist.CalculateHighestParticulatelist().First());
            
            return true;
        }

        // private method Locations listbox selected index changed
        private void constituencyListbox_SelectedIndexChanged(object sender, EventArgs e)
        {

            // Clear any items in listbox
            DataListbox.Items.Clear();

            label3.Text = "Readings:";

            var location = (Location)LocationListbox.SelectedItem;


            // Having finished generating data we can now display party data on form
            foreach (var c in location.Readings)
            {
                DataListbox.Items.Add(c);
            }

        }

        // functionality list selected index change
        private void lstFunctionality_SelectedIndexChanged(object sender, EventArgs e)
        {
            var choice = Convert.ToString(lstFunctionality.SelectedItem);

            // function 1
            if (choice == "Display all location data")
            {
               DisplayLocations();
            }

            // function 2
            else if(choice == "Display particulate total. Via Location")
            {
               Displaytotal();
            }

            // function 3
            else if(choice == "Display particulate total. Via Date")
            {
               Displaydatetotal();
            }

            // function 4
            else
            {
               DisplayHighestReading();
            }
        }

        // private method Btnclose
        private void btnclose_Click(object sender, EventArgs e)
        {
            // exit application
            this.Close();
        }
    }
}
