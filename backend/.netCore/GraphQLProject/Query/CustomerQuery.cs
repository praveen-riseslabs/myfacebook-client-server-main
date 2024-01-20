using GraphQL;
using GraphQL.Types;
using GraphQLProject.Interfaces;
using GraphQLProject.Type;
namespace GraphQLProject.Query
{
    public class CustomerQuery : ObjectGraphType
    {
        public CustomerQuery(ICustomerRepository customerRepository)
        {
            Field<ListGraphType<CustomerType>>("customers").Resolve(context =>
            {
                return customerRepository.GetAllCustomers();
            });
            Field<CustomerType>("customer").Arguments(new QueryArguments(new QueryArgument<IntGraphType> { Name="customerId"})).Resolve(context =>
            {
                return customerRepository.GetCustomerTransactionsById(context.GetArgument<int>("customerId"));
            });
        }  
    }
}
