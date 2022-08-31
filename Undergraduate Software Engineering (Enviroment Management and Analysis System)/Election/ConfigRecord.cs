using System;

namespace Election
{
    /// <summary>
    /// Public class Config record
    /// </summary>
    public class ConfigRecord
    {
        // Public variable

        // Public string Filename
        public String Filename { get; }

        // constructor
        public ConfigRecord(String Filename)
        {
            this.Filename = Filename;
        }

        // Public overidden Tostring method
        public override String ToString()
        {
            return String.Format("{0}", Filename);
        }
    }
}
