<!DOCTYPE html>
<html>
<head>
    <title>Authors List</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Authors</h1>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Role</th>
        <th>Created At</th>
    </tr>
    </thead>
    <tbody>
    <!-- Iterate through the authors list -->
    <c:forEach var="author" items="${authors}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td> <!-- Display index (1-based) -->
            <td>${author.id}</td>       <!-- Display author's ID -->
            <td>${author.username}</td> <!-- Display author's username -->
            <td>${author.email}</td>    <!-- Display author's email -->
            <td>${author.role}</td>     <!-- Display author's role -->
            <td>${author.created_at}</td> <!-- Display author's created_at -->
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
