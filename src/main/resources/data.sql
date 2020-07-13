INSERT INTO public.tenant(
	id, "name", surname, dateOfBirth, "group")
	VALUES (1, "Mateusz", "Wtulich", '1998-01-01');
INSERT INTO public.tenant(
	id, "name", surname, dateOfBirth, "group")
	VALUES (1, "Kamil", "Nowak", '1993-02-05');

INSERT INTO public.flight(
	id, origin, destination, "time", "group")
	VALUES (1, "Kamil", "Nowak", '1993-02-05');
	 private Long id;
INSERT INTO public.flight(
	id, origin, destination, "time", "group")
	VALUES (1, "Kamil", "Nowak", '1993-02-05');
	 private Long id;

INSERT INTO public.flight(
	id, origin, destination, "time", "group")
	VALUES (1, "Kamil", "Nowak", '1993-02-05');
	 private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "ORIGIN", nullable = false)
    private String origin;

    @NotNull
    @Column(name = "DESTINATION", nullable = false)
    private String destination;

    @NotNull
    @Column(name = "TIME", nullable = false)
    private Time time;

    @NotNull
    @Column(name = "DAYS_OF_WEEK", nullable = false)
    private List<DayOfWeek> days;
