package main

import (
    "fmt"
    "log"
    "net/http"
	"encoding/json"
    "github.com/gorilla/mux"
	"io/ioutil"
	//"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
    "go.mongodb.org/mongo-driver/mongo/options"
    "go.mongodb.org/mongo-driver/mongo/readpref"
)
type Article struct {
	Id string `json:"Id"`
    Title string `json:"Title"`
    Desc string `json:"desc"`
    Content string `json:"content"`
}


var Articles []Article

func connect(uri string)(*mongo.Client, context.Context, context.CancelFunc, error) {
	 
// ctx will be used to set deadline for process, here 
// deadline will of 30 seconds.
ctx, cancel := context.WithTimeout(context.Background(),  30 * time.Second)

// mongo.Connect return mongo.Client method
client, err := mongo.Connect(ctx, options.Client().ApplyURI(uri))
return client, ctx, cancel, err
}

func close(client *mongo.Client, ctx context.Context, cancel context.CancelFunc){
	 
// CancelFunc to cancel to context
defer cancel()

// client provides a method to close 
// a mongoDB connection.
defer func(){

 // client.Disconnect method also has deadline.
 // returns error if any,
 if err := client.Disconnect(ctx); err != nil{
	 panic(err)
 }
}()
}
// func ping(client *mongo.Client, ctx context.Context) error{
 
//     // mongo.Client has Ping to ping mongoDB, deadline of 
//     // the Ping method will be determined by cxt
//     // Ping method return error if any occurred, then
//     // the error can be handled.
//     if err := client.Ping(ctx, readpref.Primary()); err != nil {
//         return err
//     }
//     fmt.Println("connected successfully")
//     return nil
// }
func returnAllArticles(w http.ResponseWriter, r *http.Request){
	Articles = []Article{
		Article{Id:"1", Title: "Hello", Desc: "Article Description", Content: "Article Content"},
		Article{Id:"2", Title: "Hello 4", Desc: "Article Description", Content: "Article Content"},
	}
    fmt.Println("Endpoint Hit: returnAllArticles")
    json.NewEncoder(w).Encode(Articles)
}
func deleteArticle(w http.ResponseWriter, r *http.Request) {
    // once again, we will need to parse the path parameters
    vars := mux.Vars(r)
    // we will need to extract the `id` of the article we
    // wish to delete
    id := vars["id"]

    // we then need to loop through all our articles
    for index, article := range Articles {
        // if our id path parameter matches one of our
        // articles
        if article.Id == id {
            // updates our Articles array to remove the 
            // article
            Articles = append(Articles[:index], Articles[index+1:]...)
        }
    }

}

func createNewArticle(w http.ResponseWriter, r *http.Request) {
    // get the body of our POST request
    // unmarshal this into a new Article struct
    // append this to our Articles array.    
    reqBody, _ := ioutil.ReadAll(r.Body)
    var article Article 
    json.Unmarshal(reqBody, &article)
    // update our global Articles array to include
    // our new Article
    Articles = append(Articles, article)

    json.NewEncoder(w).Encode(article)
}

func homePage(w http.ResponseWriter, r *http.Request){
    fmt.Fprintf(w, "Welcome to the HomePage!")
    fmt.Println("Endpoint Hit: homePage")
}
func  returnSingleArticle(w http.ResponseWriter, r *http.Request){
	Articles = []Article{
		Article{Id:"1", Title: "Hello", Desc: "Article Description", Content: "Article Content"},
		Article{Id:"2", Title: "Hello 4", Desc: "Article Description", Content: "Article Content"},
	}
    vars := mux.Vars(r)
    key := vars["Id"]

   // fmt.Fprintf(w, "Key: " + key)
   for _, article := range Articles {
	if article.Id == key {
		json.NewEncoder(w).Encode(article)
	}
   }
	
}

func createUser(w http.ResponseWriter, r *http.Request){
	//reqBody, _ := ioutil.ReadAll(r.Body)
}

func handleRequests() {
	myRouter := mux.NewRouter().StrictSlash(true)
    // replace http.HandleFunc with myRouter.HandleFunc
   // myRouter.HandleFunc("/", homePage)
    //myRouter.HandleFunc("/articles", returnAllArticles)
	//myRouter.HandleFunc("/article/{Id}", returnSingleArticle)
	myRouter.HandleFunc("/createuser", createUser).Methods("POST")
	//myRouter.HandleFunc("/article/{id}", deleteArticle).Methods("DELETE")
	//myRouter.HandleFunc("/article/{id}", updateArticle).Methods("PUT")
    log.Fatal(http.ListenAndServe(":10000", myRouter))
}

// func main() {
// 	client, ctx, cancel, err := connect("mongodb://localhost:27017")
// 	if err != nil {
//         panic(err)
//     }
     
//     // Release resource when the main
//     // function is returned.
//     defer close(client, ctx, cancel)
     
//     // Ping mongoDB with Ping method
//     ping(client, ctx)
//     handleRequests()
// }