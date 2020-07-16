INSERT INTO public.tenants(
	id, "name", surname, date_Of_Birth, group_name)
	VALUES (100, 'Mateusz', 'Wtulich', '1998-01-02T16:06:02.235Z', 'A');
INSERT INTO public.tenants(
	id, "name", surname, date_Of_Birth, group_name)
	VALUES (200, 'Kamil', 'Nowak', '1993-02-01T16:06:02.235Z', 'B');

INSERT INTO public.days_of_week(
	id, "name")
	VALUES (2, 'Monday');
INSERT INTO public.days_of_week(
	id, "name")
	VALUES (3, 'Tuesday');
INSERT INTO public.days_of_week(
	id, "name")
	VALUES (4, 'Wednesday');
INSERT INTO public.days_of_week(
	id, "name")
	VALUES (5, 'Thursday');
INSERT INTO public.days_of_week(
	id, "name")
	VALUES (6, 'Friday');
INSERT INTO public.days_of_week(
	id, "name")
	VALUES (7, 'Saturday');
INSERT INTO public.days_of_week(
	id, "name")
	VALUES (1, 'Sunday');

INSERT INTO public.flights(
	id, origin, destination, "time")
	VALUES (100, 'Warszawa', 'Afryka', '10:00:00');
INSERT INTO public.flights(
	id, origin, destination, "time")
	VALUES (200, 'Warszawa', 'Chicago', '18:00:00');

INSERT INTO public.flight_days_of_week(
    DAYS_OF_WEEK_ID, FLIGHT_ID)
    VALUES (5,100);
INSERT INTO public.flight_days_of_week(
    DAYS_OF_WEEK_ID, FLIGHT_ID)
    VALUES (3,100);
INSERT INTO public.flight_days_of_week(
    DAYS_OF_WEEK_ID, FLIGHT_ID)
    VALUES (2,200);
INSERT INTO public.flight_days_of_week(
    DAYS_OF_WEEK_ID, FLIGHT_ID)
    VALUES (7,200);

INSERT INTO public.FLIGHTS_WITH_PRICE(
    id, BASE_PRICE, "date", flight_id)
    VALUES (1000, 30, '2020-01-02T16:06:02.235Z', 100);

INSERT INTO public.FLIGHTS_WITH_PRICE(
    id, BASE_PRICE, "date", flight_id)
    VALUES (2000, 21, '2020-02-01T16:06:02.235Z', 200);

INSERT INTO public.DAY_OF_WEEK_CRITERIA(
    id, DAY_OF_WEEK_ID)
    VALUES(1, 5);

INSERT INTO public.DAY_OF_BIRTH_CRITERIA(
    id)
    VALUES(2);

INSERT INTO public.DESTINATION_CRITERIA(
    id, destination)
    VALUES(3, 'Afryka');
