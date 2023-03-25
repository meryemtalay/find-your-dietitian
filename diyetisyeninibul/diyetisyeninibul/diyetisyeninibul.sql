--
-- PostgreSQL database dump
--

-- Dumped from database version 15.0
-- Dumped by pg_dump version 15.0

-- Started on 2022-11-23 22:09:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 16763)
-- Name: diyetisyen; Type: TABLE; Schema: public; Owner: pg_database_owner
--

CREATE TABLE public.diyetisyen (
    first_name character varying,
    last_name character varying,
    bio character varying,
    rating integer,
    diyetisyen_id integer NOT NULL,
    breakfast character varying,
    lunch character varying,
    dinner character varying,
    email character varying,
    number_of_orders integer DEFAULT 0 NOT NULL,
    sum integer DEFAULT 0 NOT NULL,
    diyetisyen_photo character varying,
    breakfast_photo character varying,
    lunch_photo character varying,
    dinner_photo character varying
);


ALTER TABLE public.diyetisyen OWNER TO pg_database_owner;

--
-- TOC entry 215 (class 1259 OID 16789)
-- Name: diyetisyen_id_seq; Type: SEQUENCE; Schema: public; Owner: pg_database_owner
--

ALTER TABLE public.diyetisyen ALTER COLUMN diyetisyen_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.diyetisyen_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3318 (class 0 OID 16763)
-- Dependencies: 214
-- Data for Name: diyetisyen; Type: TABLE DATA; Schema: public; Owner: pg_database_owner
--

COPY public.diyetisyen (first_name, last_name, bio, rating, diyetisyen_id, breakfast, lunch, dinner, email, number_of_orders, sum, diyetisyen_photo, breakfast_photo, lunch_photo, dinner_photo) FROM stdin;
Sasha	Wang	Merhaba, ben Sasha. Asya mutfağından yemekler hazırlıyorum.	0	2	Yoğurtlu Meyveli Bowl	Ton Balıklı Noodle	Tavuk Göğsü Menü	diyetisyen2	0	0	dyt2.png	breakfast_2.png	lunch_2.png	dinner_2.png
Eylül	Bulut	Ben Eylül. Beslenme uzmanıyım. Bol proteinli menüler hazırlıyorum.	0	3	Yoğurtlu Meyveli Bowl	Somon Salata	Bonfile Menü	diyetisyen3	0	0	dyt3.png	breakfast_3.png	lunch_3.png	dinner_3.png
Büşra	Yavuz	Eğitimimi Medeniyet Üniversitesinde tamamladıktan sonra İstanbul Üniversitesinde yüksek lisans yaptım. Vejetaryen menüleri hazırlıyorum	0	1	Avokado Bowl	Salad Bar	Yeşil Salata	diyetisyen1	0	0	dyt1.png	breakfast_1.png	lunch_1.png	dinner_1.png
\.


--
-- TOC entry 3325 (class 0 OID 0)
-- Dependencies: 215
-- Name: diyetisyen_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pg_database_owner
--

SELECT pg_catalog.setval('public.diyetisyen_id_seq', 43, true);


--
-- TOC entry 3175 (class 2606 OID 16802)
-- Name: diyetisyen diyetisyen_pkey; Type: CONSTRAINT; Schema: public; Owner: pg_database_owner
--

ALTER TABLE ONLY public.diyetisyen
    ADD CONSTRAINT diyetisyen_pkey PRIMARY KEY (diyetisyen_id);


-- Completed on 2022-11-23 22:09:58

--
-- PostgreSQL database dump complete
--

