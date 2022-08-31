using System.Collections.Generic;

namespace Election
{
    /// <summary>
    /// Public class Config data
    /// </summary>
    public class ConfigData
    {
        // public variables

        // Public list of config records
        public List<ConfigRecord> configRecords { get; }

        // Public int next record
        public int NextRecord { get; set; }

        // constructor
        public ConfigData()
        {
            this.NextRecord = 0;
            configRecords = new List<ConfigRecord>();
        }
    }
}
