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

(deftest reduce'-test
  (testing "arity 2"
    (is (= 15 (reduce' + [1 2 3 4 5]))))
  (testing "arity 3"
    (is (= 15 (reduce' + 1 [2 3 4 5])))))

(deftest reverse'-test
  (testing "valid sequence"
    (is (= [3 2 1] (reverse' [1 2 3])))))

(deftest every?'-test
  (testing "with empty list"
    (is (= true (every?' even? []))))
  (testing "with all true values"
    (is (= true (every?' even? [2 4 6]))))
  (testing "with all falsy values"
    (is (= false (every?' even? [1 3 5]))))
  (testing "with some true values"
    (is (= false (every?' even? [1 2])))))

(deftest some?'-test
  (testing "with empty list"
    (is (= nil (some?' even? []))))
  (testing "with all true values"
    (is (= true (some?' even? [2 4 6]))))
  (testing "with all falsy values"
    (is (= nil (some?' even? [1 3 5]))))
  (testing "with some true values"
    (is (= true (some?' even? [1 2])))))

(deftest ascending?-test
  (testing "with ascending list"
    (is (= true (ascending? [1 2 3]))))
  (testing "with not ascending list"
    (is (= false (ascending? [2 14 6])))))

(deftest sum-of-adjacent-digits-test
  (testing "with ascending list"
    (is (= [3 5] (sum-of-adjacent-digits [1 2 3])))))

(deftest difference-test
  (testing "different list"
    (is (= '(4 5) (difference [1 2 3] [1 2 3 4 5]))))
  (testing "same list"
    (is (= '() (difference [1 2 3] [1 2 3])))))
