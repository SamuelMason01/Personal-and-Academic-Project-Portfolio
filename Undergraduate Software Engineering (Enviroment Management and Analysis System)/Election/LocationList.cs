using Microsoft.SqlServer.Server;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;

namespace Election
{
    /// <summary>
    /// Public class Locationlist
    /// </summary>
    public class LocationList
    {
        // Public variables
        // Get methods

        // Public list Locations
        public List<Location> Locations { get; } // get method
        public int total;
        public int runningtotal;

        // Constructor
        public LocationList()
        {
            this.Locations = new List<Location>();
        }

        // Public method
        // Functionality: Calculate partciulate location list
        public List<String> CalculateParticulatelocationlist()
        {
            var particulatelist = new List<string>();

            var partTotal =
                from location in this.Locations
                from Reading in location.Readings
                group Reading by location.Name into totreadings
                let totalVotes = (from cand in totreadings select (int)cand.Value).Sum()
                orderby totalVotes descending
                select new
                {
                    PartyName = totreadings.Key,
                    TotalVotes = totalVotes
                };

            foreach (var p in partTotal)
            {
                particulatelist.Add(String.Format("{0}: {1} Total particulates", p.PartyName, p.TotalVotes));
            }

            return particulatelist;

        }

        // Public method
        // Functionality: Calculate particulate date list
        public List<String> CalculateParticulatedatelist()
        {
            total = 0;

            var particulatelist = new List<string>();

            var partTotal =
                from location in this.Locations
                from Reading in location.Readings
                group Reading by Reading.date into totreadings
                let totalVotes = (from cand in totreadings select (int)cand.Value).Sum()
                orderby totreadings.Key ascending
                select new
                {
                    date = totreadings.Key,
                    TotalVotes = totalVotes,
                };

            foreach (var p in partTotal)
            {
                particulatelist.Add(String.Format("{0}: {1} Total particulates", p.date, p.TotalVotes));
                total = total + p.TotalVotes;
            }

            particulatelist.Add(Convert.ToString(""));
            particulatelist.Add(Convert.ToString( "Total particulate reading across all locations: " + total));

            return particulatelist;
        }

        // Public method
        // Functionality: Calculate highest particulate date list
        public List<string> CalculateHighestParticulatelist()
        {
            var particulatelist = new List<string>();

            var partTotal =
                from location in this.Locations
                from Reading in location.Readings
                group Reading by new { location.Name, Reading.date } into totreadings
                let tot = (from cand in totreadings select (int)cand.Value).Max()
                orderby tot descending
                
                select new
                {
                    name = totreadings.Key.Name,
                    date = totreadings.Key.date,
                    TotalVotes = tot,
                };

            foreach (var p in partTotal)
            {
                particulatelist.Add(string.Format("Particulate: {0} Location: {1}  Date: {2}",p.TotalVotes,p.name,p.date));
            }


            return particulatelist;
        }

    }
}
