using System;

namespace Election
{
    /// <summary>
    /// Public class Reading
    /// </summary>
    public class Reading
    {
        // variables
        // get methods
        public string date { get; } // date
        public double Value { get; } // value : particulate
        public double Temperature { get; } // Temperature
        public double Humidity { get; } // Humidity

        // Constructor
        public Reading( string date, double value, double temperature, double humidity)
        {
            this.date = date;
            this.Value = value;
            this.Temperature = temperature;
            this.Humidity = humidity;
        }

        // Public overidden Tostring method
        public override String ToString()
        {
            return string.Format("Date: " + this.date + " Value: " + this.Value + " Temp: " + this.Temperature + " Humidity: " + this.Humidity);
        }
    }
}
