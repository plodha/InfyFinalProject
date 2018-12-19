import { Boat } from './boat';

let today = new Date();
today = new Date(today.getTime() + 10000000000);

export const BOATS: Boat[] = [
    {
        allowedDays: null, basePrice: 999.0, boatId: '1001', boatType: 'Houseboat', location: 'Allepey', message: '', discount: 0.0666, bookingStart: new Date(new Date().getTime() + 100000000),
        description: "These boats offer the luxury of living on water and provide excellent recreational and holiday accommodation facilities."
    },

    {
        allowedDays: 5, basePrice: 850.0, boatId: "1002", boatType: "Cruiser", location: "Alappuzha", message: '', discount: 0.15, bookingStart: new Date(new Date().getTime() + 1666666666),
        description: "These boats are apt for relaxed sailing and include a galley and a berth. All modern comforts like heaters, air conditioners, and power generators are enclosed in the arrangement.",
    },

    {
        allowedDays: 5, basePrice: 680.0, boatId: "1003", boatType: "Bass Boat", location: "Kumarkom", message: '', discount: 0.05, bookingStart: new Date(new Date().getTime() + 900000000),
        description: "Bass boats are generally 14' to 23', and typically used for freshwater fishing.",
    },

    {
        allowedDays: 5, basePrice: 350.0, boatId: "1004", boatType: "Speed Boat", location: "Kumarkom", message: '', discount: 0.15, bookingStart: new Date(new Date().getTime() + 1100000000),
        description: "Performance powerboats, built for speed.",
    },

    {
        allowedDays: 5, basePrice: 500.0, boatId: "1005", boatType: "Power Catamaran", location: "Srinagar", message: '', discount: 0.05, bookingStart: new Date(new Date().getTime() + 100000000),
        description: "The power or sailing style catamarans comprise of multiple hulls and are excellent for fishing purposes and even for leisurely cruising abilities."
    },

    {
        allowedDays: null, basePrice: 400.0, boatId: "1006", boatType: "Speed Boat", location: "Srinagar", message: '', discount: 0.10, bookingStart: new Date(new Date().getTime() + 1000000000),
        description: "Performance powerboats, built for speed.",
    },

    {
        allowedDays: 5, basePrice: 1200.0, boatId: "1007", boatType: "Cruiser", location: "Srinagar", message: '', discount: 0.05, bookingStart: new Date(new Date().getTime() + 1000000000),
        description: "These boats are apt for relaxed sailing and include a galley and a berth. All modern comforts like heaters, air conditioners, and power generators are enclosed in the arrangement.",
    }
];   