package com.eg.spring_app;

public class Data {
     public void init() {
        System.out.print("\nOperator: " + "\t| attribute: " + "\t| customOperatorValue: " + "\t| Result: ");
    }
 
    public boolean validateOperator(String moduleAttr, String customOperatorValue, String operator) {
        try {
            boolean result = false;
 
            if ((moduleAttr != null && moduleAttr.length() > 0)
                    && (customOperatorValue != null && customOperatorValue.length() > 0)
                    && (operator != null && operator.length() > 1)) {
 
                switch (operator.toLowerCase()) {
                    case "equal":
                        result = moduleAttr.equals(customOperatorValue);
                        break;
                    case "not equal":
                        result = !moduleAttr.equals(customOperatorValue);
                        break;
                    case "greater than":
                        result = Integer.parseInt(moduleAttr) > Integer.parseInt(customOperatorValue);
                        break;
                    case "greater than or equal":
                        result = Integer.parseInt(moduleAttr) >= Integer.parseInt(customOperatorValue);
                        break;
                    case "less than":
                        result = Integer.parseInt(moduleAttr) < Integer.parseInt(customOperatorValue);
                        break;
                    case "less than or equal":
                        result = Integer.parseInt(moduleAttr) <= Integer.parseInt(customOperatorValue);
                        break;
                    case "between":
                        String[] range = customOperatorValue.split("and");
                        int lowerBound = Integer.parseInt(range[0].trim());
                        int upperBound = Integer.parseInt(range[1].trim());
                        result = Integer.parseInt(moduleAttr) >= lowerBound
                                && Integer.parseInt(moduleAttr) <= upperBound;
                        break;
                    case "not between":
                        String[] notBetweenRange = customOperatorValue.split("and");
                        int notLowerBound = Integer.parseInt(notBetweenRange[0].trim());
                        int notUpperBound = Integer.parseInt(notBetweenRange[1].trim());
                        result = !(Integer.parseInt(moduleAttr) >= notLowerBound
                                && Integer.parseInt(moduleAttr) <= notUpperBound);
                        break;
                    case "in":
                        String[] valuesIn = customOperatorValue.split(",");
                        for (String value : valuesIn) {
                            if (moduleAttr.equals(value.trim())) {
                                result = true;
                                break;
                            }
                        }
                        break;
                    case "not in":
                        String[] valuesNotIn = customOperatorValue.split(",");
                        result = true;
                        for (String value : valuesNotIn) {
                            if (moduleAttr.equals(value.trim())) {
                                result = false;
                                break;
                            }
                        }
                        break;
                    case "is null":
                        result = moduleAttr == null;
                        break;
                    case "is not null":
                        result = moduleAttr != null;
                        break;
                    case "starts with":
                        result = moduleAttr.startsWith(customOperatorValue);
                        break;
                    case "does not start with":
                        result = !moduleAttr.startsWith(customOperatorValue);
                        break;
                    case "ends with":
                        result = moduleAttr.endsWith(customOperatorValue);
                        break;
                    case "does not end with":
                        result = !moduleAttr.endsWith(customOperatorValue);
                        break;
                    case "contains":
                        result = moduleAttr.contains(customOperatorValue);
                        break;
                    case "does not contain":
                        result = !moduleAttr.contains(customOperatorValue);
                        break;
                    case "is empty":
                        result = moduleAttr.isEmpty();
                        break;
                    case "is not empty":
                        result = !moduleAttr.isEmpty();
                        break;
                    case "regexp":
                        result = moduleAttr.matches(customOperatorValue);
                        break;
                    case "not regexp":
                        result = !moduleAttr.matches(customOperatorValue);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported operator: " + operator);
                }
            }
 
            System.out.print("\n " + operator + " \t|" + moduleAttr + " \t| " + customOperatorValue + " \t| " + result
                    + "\n");
 
            return result;
 
        } catch (Exception ex) {
            System.out.print("Exception: " + ex.getMessage());
            return false;
        }
    }
}