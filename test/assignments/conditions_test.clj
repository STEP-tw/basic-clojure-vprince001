(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-divide-test
  (testing "return x/y unless y is 0")
    (is (= 2 (informative-divide 4 2)))
  (testing "return :infinite when y is 0"
    (is (= :infinite (informative-divide 4 0)))))

(deftest harishchandra-test
  (testing "return value if truthy"
    (is (= 2 (harishchandra 2))))
  (testing "return nil if false"
    (is (= nil (harishchandra false))))
  (testing "return nil if nil"
    (is (= nil (harishchandra nil)))))

(deftest yudishtira-test
  (testing "return value if truthy"
    (is (= 2 (yudishtira 2))))
  (testing "return :ashwathama if false"
    (is (= :ashwathama (yudishtira false))))
  (testing "return :ashwathama if nil"
    (is (= :ashwathama (yudishtira nil)))))

(deftest duplicate-first-test
  (testing "return coll with the first element duplicated"
    (is (= `(1 1 2 3) (duplicate-first `(1 2 3)))))
  (testing "return nil if col is empty"
    (is (= nil (duplicate-first `())))))

(deftest five-point-someone-test
  (testing "return :chetan-bhagat if y is 5"
    (is (= :chetan-bhagat (five-point-someone 1 5))))
  (testing "return :satan-bhagat if x is 5"
    (is (= :satan-bhagat (five-point-someone 5 7))))
  (testing "return :greece if x is greater than y"
    (is (= :greece (five-point-someone 3 2))))
  (testing "return :universe if all three condition fails"
    (is (= :universe (five-point-someone 3 4)))))

(deftest order-in-words-test
  (testing "return [:x-greater-than-y :y-greater-than-z] if x > y and y > z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "return [:x-greater-than-y :z-greater-than-x] if x > y and z > x"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "return [:x-greater-than-y :z-greater-than-x] if z > x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4)))))

(deftest zero-aliases-test
  (testing "return :zero for 0"
    (is (= :zero (zero-aliases 0))))
  (testing "return :empty for empty vector"
    (is (= :empty (zero-aliases []))))
  (testing "return :empty for empty list"
    (is (= :empty (zero-aliases `()))))
  (testing "return :empty-set for empty set"
    (is (= :empty-set (zero-aliases #{}))))
  (testing "return :empty-map for empty map"
    (is (= :empty-map (zero-aliases {}))))
  (testing "return :empty-string for empty string"
    (is (= :empty-string (zero-aliases ""))))
  (testing "return :not-zero as default when upper cases doesn't matches"
    (is (= :not-zero (zero-aliases "hello")))))

(deftest zero-separated-palindrome-test
  (testing "non-empty collection"
    (is (= `(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3]))))
  (testing "empty collection"
    (is (= `(0) (zero-separated-palindrome [])))))

(deftest repeat-and-truncate-test
  (testing "returns collection"
    (is (= (range 4) (repeat-and-truncate (range 4) false false 3))))
  (testing "returns collection concatenated to itself"
    (is (= `(0 1 2 3 0 1 2 3) (repeat-and-truncate (range 4) true false 3))))
  (testing "returns truncated collection concatenated to itself according to given value"
    (is (= `(0 1 2 3 0 1) (repeat-and-truncate (range 4) true true 6)))))
