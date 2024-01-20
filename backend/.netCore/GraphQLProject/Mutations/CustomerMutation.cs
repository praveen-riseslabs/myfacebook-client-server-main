using GraphQL;
using GraphQL.Types;
using GraphQLProject.Interfaces;
using GraphQLProject.Type;
using GraphQLProject.Models;

namespace GraphQLProject.Mutations
{
    public class CustomerMutation : ObjectGraphType
    {
        public CustomerMutation(ICustomerRepository customerRepository) {
            Field<CustomerType>("createCustomer").Arguments(new QueryArguments(new QueryArgument<CustomerInputType> { Name = "customer" })).Resolve(context =>
            {
                return customerRepository.AddCustomer(context.GetArgument<Customer>("customer"));
            });
            Field<CustomerType>("updateCustomer").Arguments(new QueryArguments(new QueryArgument<CustomerInputType> { Name = "customer" }, new QueryArgument<IntGraphType> { Name = "customerid" })).Resolve(context =>
            {
                var customer = context.GetArgument<Customer>("customer");
                var customerId = context.GetArgument<int>("customerId");
                return customerRepository.UpdateCustomerTransaction(customerId, customer);
            });
            Field<StringGraphType>("deleteCustomer").Arguments(new QueryArguments(new QueryArgument<IntGraphType> { Name = "customerid" })).Resolve(context =>
            {
                var customerId = context.GetArgument<int>("customerId");
                customerRepository.DeleteCustomerTransaction(customerId);
                return "Delete Successfully!";

            });
        }
    }
}
