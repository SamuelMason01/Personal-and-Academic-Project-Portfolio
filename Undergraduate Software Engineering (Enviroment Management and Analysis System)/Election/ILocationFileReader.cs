namespace Election
{
    /// <summary>
    /// Public inerface ILocationFileReader
    /// </summary>
    public interface ILocationFileReader
    {
        Location ReadLocationDataFromFile(ConfigRecord configRecord);
    }
}
