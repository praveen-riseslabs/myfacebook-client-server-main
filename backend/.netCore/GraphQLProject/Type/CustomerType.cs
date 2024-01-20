using GraphQL.Types;
using GraphQLProject.Models;
namespace GraphQLProject.Type
{
    public class CustomerType : ObjectGraphType<Customer>
    {
        public CustomerType()
        {
            Field(m => m.id);
            Field(m => m.firstName);
            Field(m => m.lastName);
            Field(m => m.email);
            Field(m => m.mobile);
        }
    }
}
