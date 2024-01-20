

public class Author{
     public string Name { get; set; }

    public static implicit operator Author(string v)
    {
        throw new NotImplementedException();
    }
}