## StarThrive Business Manager
*in Java (backend and frontend)*

‣

### 📋 Project Description
---

*Structure*

The company StarThrive is responsible for managing several businesses in the catering and grocery sectors.
It is necessary to develop an application to manage the companies under StarThrive's responsibility.
These companies have different categories and are characterized by their category, name, district, and location (GPS coordinates).

Catering businesses have a significant expense in the form of waiter wages and are thus also characterized by the number of waiters and the average annual salary cost.
They can be separated in the following categories:
- **Cafes**: are further characterized by the average daily number of customers, the average number of coffees sold per day, and the average annual revenue per coffee sold per day.
- **Bakeries**: are further characterized by the average daily number of customers, the number of cakes sold per day, and the average annual revenue per cake sold per day.
- **Restaurants**: can be local restaurants or fast-food establishments. A restaurant is characterized by the average daily number of customers and the number of days of operation per year.
  - **Local restaurant**: characterized by the number of indoor tables, the number of tables on the terrace, the annual license cost per terrace table, and the average revenue per table per day.
  - **Fast-food restaurant**: characterized by the number of indoor tables, the average revenue per table per day, the average daily number of drive-thru customers, and the average daily revenue per drive-thru customer.

Grocery category companies can be fruit shops or markets:
- **Fruit shops**: are characterized by the number of products, the average annual revenue per product, and the annual establishment cleaning cost.
- **Markets**: are characterized by type (mini, super, hyper), corridor area (m2), average annual revenue per m2, and annual establishment cleaning cost.

Since one of the main objectives of the StarThrive company is managing annual expenses and revenues, there are different ways for calculating the annual expenses and revenues of each category.

---

*Features*

The application developed for a StarThrive employee, should allow the following features:

1. List of companies managed by StarThrive, presenting at least the following information:
- Company name
- Type of company
- District
- Annual expense
- Annual revenue
- Profit (yes/no)

2. For each type of company, present the company with the highest and lowest annual revenue (name and value) and the one with the highest annual profit (name and profit value)
3. Present the 2 restaurants with the highest daily customer capacity
4. User interaction should be performed through a simple JAVA graphical interface (JFrames) allowing the user to:
- List, create, edit, and delete companies
- Display the requested listings and indicators

The application should be provided with a text file (starthrive.txt) containing data for at least 5 companies of each category. Upon startup, the application should load company data from the object file (starthrive.dat), and if it doesn't exist, load the data from the text file (starthrive.txt). It should also automatically save company changes to the object file.

---

**NOTE:** The project development has been completed, with the backend fully functional, meeting all requested features. The interface contains all necessary information and functional buttons, except for the "edit" button, which is currently non-operational. Additionally, the code includes input validation along with corresponding error messages. This project was developed within the scope of a Computer Science course by Cláudia Torres and Tiago Dias.
