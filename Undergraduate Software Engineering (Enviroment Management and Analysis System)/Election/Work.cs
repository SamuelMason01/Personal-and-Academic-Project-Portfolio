namespace Election
{
	/// <summary>
	/// Public class Work
	/// </summary>
	public class Work
	{
		//variables

        public ConfigRecord configRecord { get; } // Data used when this work is processed - config record
        private ILocationFileReader IOhandler; // Data used when this work is processed - config record

		// Constructor
		public Work(ConfigRecord data, ILocationFileReader IOhandler)
		{
			this.configRecord = data; // Data is initialised when the work is instantiated
            this.IOhandler = IOhandler;
		}

		// Public method ReadData
		public Location ReadData()
		{
			// Reads the specified file and extracts the constituency data from it to store in a Constituency object
			return IOhandler.ReadLocationDataFromFile(configRecord);
		} 
	}
}
