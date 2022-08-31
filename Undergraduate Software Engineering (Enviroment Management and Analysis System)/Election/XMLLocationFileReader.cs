using System;
using System.Linq;
using System.IO;
using System.Xml.Linq;

namespace Election
{
    /// <summary>
    /// Public class XML File Reader
    /// </summary>
    public class XMLLocationFileReader : ILocationFileReader
    {
        public Location ReadLocationDataFromFile(ConfigRecord configRecord)
        {
            // Open the file to read from on the local file system, if this file is missing then return
            // immediately from this method
            if (!File.Exists(configRecord.Filename))
            {
                // Cannot open the file as it does not exist for whatever reason, so return immediately.
                return null;
            }

            // Open file and load into memory as XML
            XDocument xmlDoc = XDocument.Load(configRecord.Filename);

            // Create Location (should only be one in file but retrieve first to be sure)
            var con = (from c in xmlDoc.Descendants("Location")
                        select c).First();

            Location constituency = new Location(con.Attribute("name").Value);

            // Obtain candidates from this constituency
            var cand = from c in con.Descendants("Reading")
                        select c;

            foreach (var c in cand)
            {
                var date = c.Attribute("date").Value;
                var value = Double.Parse(c.Element("value").Value);
                var temp = Double.Parse(c.Element("temperature").Value);
                var humidity = Double.Parse(c.Element("humidity").Value);


                Reading candidate = new Reading(date, value, temp, humidity);
                constituency.Readings.Add(candidate);
            }

            return constituency;
        }
    }
}
