using Demoshoalbackend.Models;
using Demoshoalbackend.service;
using Demoshoalbackend.Types;
using GraphQL;
using GraphQL.Types;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Demoshoalbackend.Mutations
{
    public class CustomerMutation : ObjectGraphType
    {
        public CustomerMutation(CustomerService customerService)
        {
            Field<CustomerType>("signUpCustomer")
                .Arguments(new QueryArguments(new QueryArgument<NonNullGraphType<CustomerInputType>> { Name = "customer" }))
                .Resolve(context =>
                {
                    var customerInput = context.GetArgument<Customer>("customer");
                    return customerService.SignUpCustomer(
                        customerInput.FirstName,
                        customerInput.LastName,
                        customerInput.Email,
                        customerInput.Mobile
                    );
                });
        }
    }
}
