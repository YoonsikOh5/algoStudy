package main

import "fmt"

func main() {
	var a int
	fmt.Scanln(&a)
	for i := 0; i < a; i++ {
		var w int
		var k int
		fmt.Scan(&w)
		fmt.Scan(&k)
		wd := (w / 2)
		kd := (k / 2)
		wr := (w % 2)
		kr := (k % 2)
		if wr == 0 {
			fmt.Println(wd * k)
		} else if kr == 0 {
			fmt.Println(kd * w)
		} else if wr == 1 {
			fmt.Println(wd*k + kd)
		} else if kr == 1 {
			fmt.Println(kd*w + wd)
		}
	}
}
