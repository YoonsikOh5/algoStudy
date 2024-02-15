package main

import "fmt"

func main() {
	var lv int
	var k string
	fmt.Scan(&lv)
	fmt.Scan(&k)

	score := 0

	if k == "bad" {
		score = (200 * lv)
	} else if k == "cool" {
		score = (400 * lv)
	} else if k == "great" {
		score = (600 * lv)
	} else if k == "perfect" {
		score = (1000 * lv)
	}
	fmt.Println(score)

}
