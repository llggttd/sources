package main

import "fmt"
import "net/http"
import "log"
import "os"
import "time"

const LOG_MSG = "REQUEST PATH - [%s]\n" 

func main() {
	startServer()
}

func startServer()  {
	http.HandleFunc("/", dispatcher)
	http.ListenAndServe("localhost:9999", nil)
}

func output(writer http.ResponseWriter, msg *string)  {
	writer.Header().Set("content-type", "text/html")
	fmt.Fprintf(writer, *msg)
}

func dispatcher(w http.ResponseWriter, r *http.Request) {

	var path = r.URL.Path
	var msg = fmt.Sprintf(LOG_MSG, path)
	output(w, &msg)
	log.Printf(LOG_MSG, path)

	if path == "/shutdown" {
		time.Sleep(time.Second * 2)
		os.Exit(0)
	}
}