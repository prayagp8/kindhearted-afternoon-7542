
# Travel Junky - An Online Trip Management System


![Logo](https://i.ibb.co/qrhttTV/TJ-GIT.png)


## Admin Features

- Login into the Application
- User Management
- Tours/Travels Package Management
- Route and Bus Management
- Ticket  and Hotel Booking Management
- View Reports 


## User Features

- Login as Customer
- View Routes 
- View  Tours/Travels  Packages
- Book / Print / Cancel  Tickets
- Payment  
- Provide/View Testimonials


## API Reference (pending)

#### Get all items

```http
  GET /api/items
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get item

```http
  GET /api/items/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### add(num1, num2)


