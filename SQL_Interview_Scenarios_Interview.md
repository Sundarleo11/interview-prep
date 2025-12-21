# SQL Interview Scenarios with Answers

This guide covers **10 common SQL interview questions** with:

* ✅ Schema and sample data
* ✅ Complete SQL solutions
* ✅ Expected outputs
* ✅ Explanations and interview tips
* ✅ Diagrams for JOINs, Window Functions, and PIVOT

---

## 📂 Schema & Sample Data

### **Employee Table**

| EmpID | Name  | Dept    | Salary |
| ----- | ----- | ------- | ------ |
| 1     | John  | HR      | 5000   |
| 2     | Alice | HR      | 6000   |
| 3     | Bob   | IT      | 7000   |
| 4     | Carol | IT      | 7000   |
| 5     | David | Finance | 4000   |

### **Product Table**

| ProdID | Category    | Revenue |
| ------ | ----------- | ------- |
| 101    | Electronics | 2000    |
| 102    | Electronics | 3000    |
| 103    | Clothing    | 1500    |
| 104    | Clothing    | 2500    |

### **Orders Table**

| OrderID | Customer | Month |
| ------- | -------- | ----- |
| 1       | A        | Jan   |
| 2       | B        | Jan   |
| 3       | A        | Feb   |
| 4       | C        | Feb   |

---

## ✅ **1. Find the Second Highest Salary**

```sql
SELECT MAX(Salary) AS Second_Highest
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee);
```

**Output:**

| Second\_Highest |
| --------------- |
| 6000            |

**Diagram:**

```
Employee Salaries → Sort → Remove Max → Take Max → Result
```

**Tip:** Use `DENSE_RANK()` for handling duplicates.

---

## ✅ **2. Retrieve Duplicate Rows from a Table**

```sql
SELECT Dept, COUNT(*) AS Cnt
FROM Employee
GROUP BY Dept
HAVING COUNT(*) > 1;
```

**Output:**

| Dept | Cnt |
| ---- | --- |
| HR   | 2   |
| IT   | 2   |

**Diagram:**

```
Employee → Group by Dept → Count → Filter count > 1
```

---

## ✅ **3. Find Employees Who Have the Same Department as 'John'**

```sql
SELECT * FROM Employee
WHERE Dept = (SELECT Dept FROM Employee WHERE Name='John');
```

**Output:**

| EmpID | Name  | Dept | Salary |
| ----- | ----- | ---- | ------ |
| 1     | John  | HR   | 5000   |
| 2     | Alice | HR   | 6000   |

**Diagram:**

```
Employee ─┐
          │ Compare Dept = John's Dept
          └─ Result
```

---

## ✅ **4. Delete All Duplicate Rows Except One**

```sql
DELETE FROM Employee
WHERE EmpID NOT IN (
  SELECT MIN(EmpID)
  FROM Employee
  GROUP BY Name, Dept, Salary
);
```

**Tip:** Always take backup before delete.

**Diagram:**

```
Group duplicates → Keep MIN(EmpID) → Delete others
```

---

## ✅ **5. Pivot Rows into Columns**

```sql
SELECT Dept,
  SUM(CASE WHEN Name='John' THEN Salary ELSE 0 END) AS John_Salary,
  SUM(CASE WHEN Name='Alice' THEN Salary ELSE 0 END) AS Alice_Salary
FROM Employee
GROUP BY Dept;
```

**Diagram:**

```
Rows → CASE logic → Aggregation → Columns
```

---

## ✅ **6. Find Nth Highest Salary**

```sql
SELECT Salary FROM (
  SELECT Salary, DENSE_RANK() OVER(ORDER BY Salary DESC) AS rnk
  FROM Employee
) t
WHERE rnk = 3;
```

**Output:** 5000

**Diagram:**

```
Salaries → Sort Desc → Assign Rank → Filter rank=3
```

---

## ✅ **7. Get Top 3 Products by Revenue in Each Category**

```sql
SELECT * FROM (
  SELECT Category, ProdID, Revenue,
  RANK() OVER(PARTITION BY Category ORDER BY Revenue DESC) AS rnk
  FROM Product
) t
WHERE rnk <= 3;
```

**Diagram:**

```
Partition by Category → Rank → Take top 3
```

---

## ✅ **8. Running Total Using Window Functions**

```sql
SELECT EmpID, Name, Salary,
SUM(Salary) OVER(ORDER BY EmpID) AS Running_Total
FROM Employee;
```

**Diagram:**

```
Rows → Window SUM → Cumulative calculation
```

---

## ✅ **9. Customers Purchased in January but Not February**

```sql
SELECT DISTINCT Customer
FROM Orders
WHERE Month='Jan'
AND Customer NOT IN (
  SELECT Customer FROM Orders WHERE Month='Feb'
);
```

**Diagram:**

```
Jan Customers → EXCEPT → Feb Customers
```

---

## ✅ **10. Detect Gaps in Sequences**

```sql
SELECT (OrderID + 1) AS Missing_From
FROM Orders o
WHERE NOT EXISTS (
  SELECT 1 FROM Orders WHERE OrderID = o.OrderID + 1
);
```

**Diagram:**

```
Sequence → Check next → Find missing
```

---


