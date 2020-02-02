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
