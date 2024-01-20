using Demoshoalbackend.Mutations;
using Demoshoalbackend.Queries;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


namespace Demoshoalbackend.schemas
{
    public class CustomerSchema : GraphQL.Types.Schema
    {
        public CustomerSchema(CustomerQuery customerQuery, CustomerMutation customerMutation)
            
        {
            Query = customerQuery;
            Mutation = customerMutation;
        }
    }
}
