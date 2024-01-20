using GraphQL.Types;
namespace GraphQLProject.Type
{
    public class CustomerInputType : InputObjectGraphType
    {
        public CustomerInputType() {
            Field<IntGraphType>("id");
            Field<StringGraphType>("firstName");
            Field<StringGraphType>("lastName");
            Field<StringGraphType>("email");
            Field<StringGraphType>("mobile");
        }
    }
}
