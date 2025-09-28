# User API - CRUD (Spring Boot)

Dokumentasi API untuk **User Management** pada aplikasi ini. Semua endpoint menggunakan format **JSON**.

## Base URL
http://localhost:8080/users

---

## Endpoints

### 1. Create User
**Request**
- Method: `POST`
- URL: `/users/register`
- Headers: `Content-Type: application/json`

**Body**
```json
{
  "username": "Admin",
  "password": "admin123",
  "role": "ADMIN",
  "userStatus": "ACTIVE"
}

```

**Response**
```json
{
  "message": "Data berhasil ditambah"
}


```

### 2. Get All Users
**Request**
- Method: `GET`
- URL: `/users/find-all`
- Headers: `Content-Type: application/json`

**Body**
```json
[
  {
    "id": 1,
    "username": "Admin",
    "password": "123456",
    "role": "ADMIN",
    "userStatus": "ACTIVE"
  },
  {
    "id": 2,
    "username": "Admin",
    "password": "123456",
    "role": "ADMIN",
    "userStatus": "ACTIVE"
  }
]
```

### 3. Get User By ID
**Request**
- Method: `GET`
- URL: `/users/{id}`
- Headers: `Content-Type: application/json`

**Body**
```json
{
  "id": 1,
  "username": "Admin",
  "password": "123456",
  "role": "ADMIN",
  "userStatus": "ACTIVE"
}
```