package com.eg.freshers
import spock.lang.Specification

class DerivedDataSpec extends Specification {

    def "test validateOperator method"() {
        setup:
        DerivedData derivedData = new DerivedData()

        expect:
        derivedData.validateOperator(moduleAttr, customOperatorValue, operator) == expectedResult

        where:
        moduleAttr | customOperatorValue | operator           | expectedResult
        "5"        | "5"                 | "equal"            | true
        "5"        | "6"                 | "not equal"        | true
        "5"        | "4"                 | "greater than"     | true
        "5"        | "5"                 | "greater than or equal" | true
        "5"        | "6"                 | "less than"        | true
        "5"        | "5"                 | "less than or equal" | true
        "5"        | "4 and 6"           | "between"          | true
        "5"        | "4 and 6"           | "not between"      | false
        "5"        | "5,6,7"             | "in"               | true
        "5"        | "6,7,8"             | "not in"           | true
        null       | null                | "is null"          | true
        "5"        | null                | "is not null"      | true
        "hello"    | "he"                | "starts with"      | true
        "hello"    | "he"                | "does not start with" | false
        "hello"    | "lo"                | "ends with"        | true
        "hello"    | "lo"                | "does not end with" | false
        "hello"    | "ell"               | "contains"         | true
        "hello"    | "ell"               | "does not contain" | false
        ""         | null                | "is empty"         | true
        "hello"    | null                | "is not empty"     | true
        "hello"    | "h.*o"              | "regexp"           | true
        "hello"    | "h.*o"              | "not regexp"       | false
    }
}
