# Detailed Description of Key Features

This document provides a detailed description of the key features for the Renter and Owner apps.

## Renter (Borrower) Application Flow

### Tool Search & Discovery

*   **Advanced Search Filters:** The search screen will feature a comprehensive set of filters to help renters find the perfect tool. These filters will be implemented using a combination of native Android UI components:
    *   **Tool Type & Brand:** Checkboxes or a multi-select dropdown menu.
    *   **Availability Dates:** A native Android Date Picker dialog will be used to select the start and end dates of the rental period.
    *   **Rental Price Range:** A Range SeekBar will be used to select the desired price range.
    *   **Distance/Location:** A slider will be used to select the search radius. Google Location Services will be used to get the user's current location.
    *   **Owner Ratings:** A RatingBar will be used to filter tools by owner rating.
*   **Efficient Display of Search Results:** Search results will be displayed in a `RecyclerView` with a custom item layout. The layout will be optimized for smooth scrolling and will include a thumbnail image of the tool, its name, price, and owner rating.

### Tool Listing Details

The tool detail screen will provide comprehensive information about the tool, including:

*   **Multiple High-Resolution Tool Images:** A carousel/gallery will be used to display multiple images of the tool. Images will be loaded and cached efficiently using the Glide library.
*   **Detailed Description:** A detailed description of the tool, including its specifications and features.
*   **Rental Rates:** The rental rates per day and per week.
*   **Availability Calendar:** A calendar view will be used to display the tool's availability.
*   **Owner's Profile Summary:** A summary of the owner's profile, including their name, photo, and rating.
*   **Pick-up/Delivery Options:** The available pick-up and delivery options.

### Booking Process

The booking process will be a simple, step-by-step flow:

1.  The renter selects the desired rental dates from the availability calendar.
2.  The renter submits a rental request.
3.  The owner receives the rental request and can either accept or decline it.
4.  If the owner accepts the request, the renter receives a confirmation and proceeds to payment.
5.  Android Architecture Components (ViewModel, LiveData/Flow) will be used to manage the booking state across different screens.

### In-App Communication

A secure in-app messaging system will be implemented using Firebase Firestore for real-time chat functionality. This will allow renters and owners to communicate with each other without having to share their personal contact information.

### Secure Payment Integration

The Razorpay SDK will be integrated for secure payment processing. The payment flow will be as follows:

1.  The renter selects the payment method and enters their payment details.
2.  The payment is processed by Razorpay.
3.  The app receives a payment status update from Razorpay.
4.  If the payment is successful, the booking is confirmed.

### Reviews & Ratings

After the rental period is over, renters will be able to submit a detailed review and rating for the tool and the owner. The review will include a star rating, a written description, and photos.

## Owner (Lender) Application Flow

### Tool Listing Management

*   **Easy Tool Listing:** Owners will be able to easily list a new tool using a simple, intuitive form. The form will include fields for the tool's name, description, photos, rental rates, and availability.
*   **Flexible Layouts:** The tool listing form will be structured for ease of use using ConstraintLayout.

### Availability Management

Owners will be able to manage their tool's availability calendar, blocking out dates or setting recurring availability.

### Rental Request Management

Owners will receive a notification when they receive a new rental request. They can then review the request and either accept or decline it.

### Payouts

Owners will be able to securely link their bank accounts for payouts. They will also be able to view their earning history.

### Tool Condition Reporting

Owners will be able to document the tool's condition (with photos and notes) before and after each rental. This will help to prevent disputes over damage.
