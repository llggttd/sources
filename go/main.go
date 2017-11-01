package main

import "fmt"
import "net/http"

func main() {
	http.HandleFunc("/", dispatcher)
	http.ListenAndServe("localhost:9999", nil)
}

func dispatcher(w http.ResponseWriter, r *http.Request) {
	var path = r.URL.Path
	fmt.Println(path)
	w.Header().Set("content-type", "text/html")
	fmt.Fprintf(w, "Hello")
}