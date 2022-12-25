### About
The project describes a parking system domain.

Considerations:
- External payment system
- Customer fills license plate during payment
- Vehicle types are ignored
- Devices: ticket issuing, ticket scanning, parking sensor, ticket payment device

Events:
- Ticket issuing device sends `TicketIssuedEvent`
- Ticket scanner near a gate sends `ValidTicketScannedEvent`
- Parking sensor sends `VehicleParkedEvent` and `VehicleUnParkedEvent`
- Ticket payment device sends `TicketPaidEvent`
