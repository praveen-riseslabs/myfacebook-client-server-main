using GraphQLProject.Mutations;
using GraphQLProject.Query;
namespace GraphQLProject.Schema
{
    public class CustomerSchema: GraphQL.Types.Schema
    {
        public CustomerSchema(CustomerQuery customerQuery, CustomerMutation customerMutation) {
            Query = customerQuery;
            Mutation = customerMutation;
        }
    }
}
