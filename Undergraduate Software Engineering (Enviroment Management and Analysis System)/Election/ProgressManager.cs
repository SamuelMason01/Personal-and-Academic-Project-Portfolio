namespace Election
{
    /// <summary>
    /// Public class Progress manager
    /// </summary>
    public class ProgressManager
    {
        // Variables

        // private int Items remaining
        private int itemsRemaining;
        public int ItemsRemaining // get and set methods
        {
            get
            {
                lock(this)
                {
                    return itemsRemaining;
                }
            }

            set
            {
                lock (this)
                {
                    // LOCK control for potential multiple thread access to this property
                    itemsRemaining = value;
                }
            }
        }

        // Constuctor
        public ProgressManager()
        {
            this.ItemsRemaining = 0;
        }

        // Constuctor with params
        public ProgressManager(int itemsRemaining)
        {
            this.ItemsRemaining = itemsRemaining;
        }
    }
}
