using System;
using System.Collections.Generic;

namespace Election
{
    /// <summary>
    /// Public class Location
    /// </summary>
    public class Location
    {
        // Public variables
        // get methods

        // public string Name
        public String Name { get; }

        // Public list Readings
        public List<Reading> Readings { get; }

        // Constructor
        public Location(String name)
        {
            this.Name = name;
            this.Readings = new List<Reading>();
            
        }

        // Public overidden Tostring method
        public override String ToString()
        {
            return String.Format("Location: {0}", this.Name);
        }
    }
}
