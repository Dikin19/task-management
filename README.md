# User API - CRUD (Spring Boot)

Dokumentasi API untuk **User Management** pada aplikasi ini. Semua endpoint menggunakan format **JSON**.

## Base URL
http://localhost:8080/api/users

---

## Endpoints

### 1. Create User
**Request**
- Method: `POST`
- URL: `/api/users`
- Headers: `Content-Type: application/json`

**Body**
```json
{
  "name": "Admin",
  "email": "Admin@example.com",
  "password": "admin123"
}

```

**Response**
```json
{
  "id": 1,
  "name": "Admin",
  "email": "Admin@example.com"
}

```

### 2. Get All Users
**Request**
- Method: `GET`
- URL: `/api/users`
- Headers: `Content-Type: application/json`

**Body**
```json
[
  {
    "id": 1,
    "name": "Admin",
    "email": "Admin@example.com"
  },
  {
    "id": 2,
    "name": "Member",
    "email": "Member@example.com"
  }
]
```

### 3. Get User By ID
**Request**
- Method: `GET`
- URL: `/api/users/{id}`
- Headers: `Content-Type: application/json`

**Body**
```json
{
  "id": 1,
  "name": "Admin",
  "email": "Admin@example.com"
}
```

### 4. Update User
**Request**
- Method: `PUT`
- URL: `/api/users/{id}`
- Headers: `Content-Type: application/json`

**Body**
```json
{
  "name": "John Updated",
  "email": "john.updated@example.com",
  "password": "newpassword123"
}
```
**Response**
```json
{
  "id": 1,
  "name": "John Updated",
  "email": "john.updated@example.com"
}
```

### 5. Delete User
**Request**
- Method: `DELETE`
- URL: `/api/users/{id}`
- Headers: `Content-Type: application/json`

{
  "message": "User deleted successfully"
}