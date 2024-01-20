using Demoshoalbackend.Mutations;
using Demoshoalbackend.Queries;
using Demoshoalbackend.schemas;
using Demoshoalbackend.service;
using Demoshoalbackend.Types;
using GraphQL;
using GraphQL.Types;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using Microsoft.OpenApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web.Http.Dependencies;

namespace Demoshoalbackend
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {

            //services.AddControllers();
            //services.AddSwaggerGen(c =>
            //{
            //    c.SwaggerDoc("v1", new OpenApiInfo { Title = "Demoshoalbackend", Version = "v1" });
            //});

            services.AddSingleton<CustomerService>();
            services.AddSingleton<CustomerType>();
            services.AddSingleton<CustomerInputType>();
            services.AddSingleton<CustomerQuery>();
            services.AddSingleton<CustomerMutation>();
            services.AddSingleton<CustomerSchema>();
            services.AddGraphQL(options =>
                options.AddAutoSchema<CustomerSchema>()
            .AddSystemTextJson());
        }


    

    // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
     public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
                app.UseSwagger();
                app.UseSwaggerUI(c => c.SwaggerEndpoint("/swagger/v1/swagger.json", "Demoshoalbackend v1"));
            }

        


        app.UseHttpsRedirection();

            //app.UseRouting();
            app.UseGraphQL("/graphql");
            app.UseGraphQL<CustomerSchema>();
            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapGraphQL();
            });
        }
    }
}
