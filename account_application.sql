--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-09-23 15:16:20

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
-- TOC entry 217 (class 1259 OID 16573)
-- Name: contract; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contract (
    id character varying(255) NOT NULL,
    name character varying(255)
);


ALTER TABLE public.contract OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16580)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id bigint NOT NULL,
    account_type character varying(255),
    business_requirements character varying(255)[],
    name character varying(255),
    contract character varying(255),
    details_id bigint
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16424)
-- Name: customer_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.customer_seq OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16587)
-- Name: details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.details (
    customer_id bigint NOT NULL,
    dob date,
    city character varying(255),
    sex character varying(255),
    CONSTRAINT details_dob_check CHECK ((dob < '2002-01-01'::date))
);


ALTER TABLE public.details OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16425)
-- Name: details_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.details_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.details_seq OWNER TO postgres;

--
-- TOC entry 4855 (class 0 OID 16573)
-- Dependencies: 217
-- Data for Name: contract; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contract (id, name) FROM stdin;
a1	fulltime
a2	fulltime
a3	fulltime
\.


--
-- TOC entry 4856 (class 0 OID 16580)
-- Dependencies: 218
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (id, account_type, business_requirements, name, contract, details_id) FROM stdin;
253	buyer	{IT,SEO}	Rahul	a1	253
254	buyer	{IT,SEO}	Aishwarya	a2	254
255	buyer	{IT,SEO}	Manav	a3	255
\.


--
-- TOC entry 4857 (class 0 OID 16587)
-- Dependencies: 219
-- Data for Name: details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.details (customer_id, dob, city, sex) FROM stdin;
253	2001-01-10	Delhi	M
254	1998-07-10	Bhopal	F
255	1995-11-28	Bihar	M
\.


--
-- TOC entry 4863 (class 0 OID 0)
-- Dependencies: 215
-- Name: customer_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_seq', 301, true);


--
-- TOC entry 4864 (class 0 OID 0)
-- Dependencies: 216
-- Name: details_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.details_seq', 301, true);


--
-- TOC entry 4699 (class 2606 OID 16579)
-- Name: contract contract_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contract
    ADD CONSTRAINT contract_pkey PRIMARY KEY (id);


--
-- TOC entry 4701 (class 2606 OID 16586)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- TOC entry 4707 (class 2606 OID 16594)
-- Name: details details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.details
    ADD CONSTRAINT details_pkey PRIMARY KEY (customer_id);


--
-- TOC entry 4703 (class 2606 OID 16596)
-- Name: customer uk_3htojdsqh8rqr908vm36xjkha; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT uk_3htojdsqh8rqr908vm36xjkha UNIQUE (contract);


--
-- TOC entry 4705 (class 2606 OID 16598)
-- Name: customer uk_5wr0q5nisq6d942e6xuxx6xwd; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT uk_5wr0q5nisq6d942e6xuxx6xwd UNIQUE (details_id);


--
-- TOC entry 4708 (class 2606 OID 16604)
-- Name: customer fkddo4bj0yv9r1pwbbt0psyak61; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT fkddo4bj0yv9r1pwbbt0psyak61 FOREIGN KEY (details_id) REFERENCES public.details(customer_id);


--
-- TOC entry 4709 (class 2606 OID 16599)
-- Name: customer fkpck1njvddp9410teile5uarrc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT fkpck1njvddp9410teile5uarrc FOREIGN KEY (contract) REFERENCES public.contract(id);


-- Completed on 2023-09-23 15:16:20

--
-- PostgreSQL database dump complete
--

