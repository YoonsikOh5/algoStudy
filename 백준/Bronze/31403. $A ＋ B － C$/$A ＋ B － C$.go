package main

import (
	"fmt"
	"strconv"
)

func main() {
	var a int
	var b int
	var c int

	fmt.Scanln(&a)
	fmt.Scanln(&b)
	fmt.Scanln(&c)

	fmt.Println((a + b - c))
	var sa string = strconv.Itoa(a)
	var sb string = strconv.Itoa(b)
	sc := sa + sb
	var ab, _ = strconv.Atoi(sc)
	fmt.Println((ab - c))
}
