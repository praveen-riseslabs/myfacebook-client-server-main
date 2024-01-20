using Demoshoalbackend.service;
using Demoshoalbackend.Types;
using GraphQL.Types;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Demoshoalbackend.Queries
{
    public class CustomerQuery : ObjectGraphType
    {
        public CustomerQuery(CustomerService customerService)
        {
            Field<ListGraphType<CustomerType>>("customers")
                .Resolve(context => customerService.GetCustomers());
        }
    }
}
