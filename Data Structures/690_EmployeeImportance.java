/*
690. Employee Importance

You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.

You are given an array of employees employees where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.

*/

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution
{
    private int getImportance(Map<Integer, Employee> map, int empid)
    {
        Employee emp    = map.get(empid);
        int importance = emp.importance;

        for (int sub : emp.subordinates)
            importance += getImportance(map, sub);

        return importance;
    }

    public int getImportance(List<Employee> employees, int id)
    {
        int importance = 0;

        Map<Integer, Employee> map = new HashMap<>();

        for (Employee e : employees)
            map.put(e.id, e);

        return getImportance(map, id);
    }
}