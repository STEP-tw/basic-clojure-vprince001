(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map'"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "returns empty collection for empty collection"
      (is (= [] (map' identity []))))))

(deftest count'-test
  (testing "returns count of elements in collection"
    (is (= 2 (count (range 2)))))
  (testing "returns zero for empty collection"
    (is (= 0 (count (range 0))))))

(deftest filter'-test
  (testing "returns collection of elements which matches the condition"
    (is (= [0 2] (filter' even? (range 4))))))
