--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0 (Debian 14.0-1.pgdg110+1)
-- Dumped by pg_dump version 14.0 (Debian 14.0-1.pgdg110+1)

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
-- Name: anuncios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.anuncios (
    codigo character varying(20) NOT NULL,
    titulo character varying(1000) NOT NULL,
    vendedor_codigo character varying(10) NOT NULL,
    preco numeric NOT NULL,
    data_anuncio date,
    num_vendas integer
);


ALTER TABLE public.anuncios OWNER TO postgres;

--
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    id bigint NOT NULL,
    cep character varying(255),
    cidade character varying(255),
    complemento character varying(255),
    logradouro character varying(255),
    numero integer NOT NULL,
    uf character varying(255),
    vendedor_codigo character varying(255)
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endereco_id_seq OWNER TO postgres;

--
-- Name: endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endereco_id_seq OWNED BY public.endereco.id;


--
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    id bigint NOT NULL,
    data date
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- Name: pedido_anuncios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido_anuncios (
    pedido_id bigint NOT NULL,
    anuncios_codigo character varying(255) NOT NULL
);


ALTER TABLE public.pedido_anuncios OWNER TO postgres;

--
-- Name: pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_id_seq OWNER TO postgres;

--
-- Name: pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedido_id_seq OWNED BY public.pedido.id;


--
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venda (
    id bigint NOT NULL,
    data date,
    formapagamento character varying(255),
    valortotal numeric(19,2),
    vendedor_codigo character varying(255),
    forma_pagamento character varying(255),
    valor_total numeric(19,2)
);


ALTER TABLE public.venda OWNER TO postgres;

--
-- Name: venda_anuncios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.venda_anuncios (
    venda_id bigint NOT NULL,
    anuncios_codigo character varying(255) NOT NULL
);


ALTER TABLE public.venda_anuncios OWNER TO postgres;

--
-- Name: venda_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.venda_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.venda_id_seq OWNER TO postgres;

--
-- Name: venda_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.venda_id_seq OWNED BY public.venda.id;


--
-- Name: vendedores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendedores (
    codigo character varying(10) NOT NULL,
    cpf character varying(14) NOT NULL,
    nome character varying(255) NOT NULL,
    situacao character varying(255)
);


ALTER TABLE public.vendedores OWNER TO postgres;

--
-- Name: endereco id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco ALTER COLUMN id SET DEFAULT nextval('public.endereco_id_seq'::regclass);


--
-- Name: pedido id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido ALTER COLUMN id SET DEFAULT nextval('public.pedido_id_seq'::regclass);


--
-- Name: venda id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda ALTER COLUMN id SET DEFAULT nextval('public.venda_id_seq'::regclass);


--
-- Data for Name: anuncios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.anuncios (codigo, titulo, vendedor_codigo, preco, data_anuncio, num_vendas) FROM stdin;
MLB01457688	Honda HR-V 1.8 16V EX	MLB077	89889	2021-10-05	1
MLB09648911	Iphone 13 PRO MAX 1TB	MLB854	15000	2021-10-01	7
\.


--
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco (id, cep, cidade, complemento, logradouro, numero, uf, vendedor_codigo) FROM stdin;
1	12345-678	Marica	Vizinho do Zé	Rua F	1	RJ	MLB077
2	77411-332	Curitiba	apt 52	Rua A	1	PR	MLB854
\.


--
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido (id, data) FROM stdin;
1	\N
2	2021-10-11
\.


--
-- Data for Name: pedido_anuncios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido_anuncios (pedido_id, anuncios_codigo) FROM stdin;
1	MLB01457688
\.


--
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venda (id, data, formapagamento, valortotal, vendedor_codigo, forma_pagamento, valor_total) FROM stdin;
1	2021-10-07	A_PRAZO	89889.00	MLB077	\N	\N
2	2021-10-07	A_PRAZO	15000.00	MLB854	\N	\N
3	2021-10-07	A_PRAZO	15000.00	MLB854	\N	\N
4	2021-10-07	A_PRAZO	15000.00	MLB854	\N	\N
5	2021-10-07	A_PRAZO	15000.00	MLB854	\N	\N
6	2021-10-07	A_PRAZO	15000.00	MLB854	\N	\N
7	2021-10-07	A_PRAZO	15000.00	MLB854	\N	\N
8	2021-10-07	A_VISTA	15000.00	MLB854	\N	\N
\.


--
-- Data for Name: venda_anuncios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venda_anuncios (venda_id, anuncios_codigo) FROM stdin;
\.


--
-- Data for Name: vendedores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vendedores (codigo, cpf, nome, situacao) FROM stdin;
MLB077	001.002.003-01	Filipe	\N
MLB854	005.007.001-11	Anna	\N
MLB227	009.005.002-45	Mario	\N
MLB333	006.004.003-21	Francisca	\N
MLB470	002.005.008-56	Carlos	\N
MLB743	007.003.002-21	Valéria	\N
MLB898	004.008.000-88	Patricia	\N
MLB705	001.001.011-11	Nikola Tesla	\N
MLB562	002.004.002-11	Karine	\N
MLB197	000.007.008-46	João	\N
MLB893	004.002.009-00	Rosa	\N
\.


--
-- Name: endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endereco_id_seq', 2, true);


--
-- Name: pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_id_seq', 2, true);


--
-- Name: venda_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.venda_id_seq', 8, true);


--
-- Name: anuncios anuncios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.anuncios
    ADD CONSTRAINT anuncios_pkey PRIMARY KEY (codigo);


--
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);


--
-- Name: venda venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (id);


--
-- Name: vendedores vendedores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendedores
    ADD CONSTRAINT vendedores_pkey PRIMARY KEY (codigo);


--
-- Name: venda_anuncios fk9jvse1ham9uj9l71qtpcsi0cn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda_anuncios
    ADD CONSTRAINT fk9jvse1ham9uj9l71qtpcsi0cn FOREIGN KEY (anuncios_codigo) REFERENCES public.anuncios(codigo);


--
-- Name: anuncios fk_vendedor_anuncios; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.anuncios
    ADD CONSTRAINT fk_vendedor_anuncios FOREIGN KEY (vendedor_codigo) REFERENCES public.vendedores(codigo);


--
-- Name: pedido_anuncios fkcy4382sg7sgb8lg80kyn2jn07; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_anuncios
    ADD CONSTRAINT fkcy4382sg7sgb8lg80kyn2jn07 FOREIGN KEY (anuncios_codigo) REFERENCES public.anuncios(codigo);


--
-- Name: endereco fkh4ecvgffvedrkvc80r8wcy6k9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT fkh4ecvgffvedrkvc80r8wcy6k9 FOREIGN KEY (vendedor_codigo) REFERENCES public.vendedores(codigo);


--
-- Name: venda fkhq1612vqt06lx6r8m45u0vpf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT fkhq1612vqt06lx6r8m45u0vpf FOREIGN KEY (vendedor_codigo) REFERENCES public.vendedores(codigo);


--
-- Name: pedido_anuncios fkq1j5j0y7ic2bntcv4m56th0pa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido_anuncios
    ADD CONSTRAINT fkq1j5j0y7ic2bntcv4m56th0pa FOREIGN KEY (pedido_id) REFERENCES public.pedido(id);


--
-- Name: venda_anuncios fkrkl2ko7j5mxx8vp2r6xj167x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda_anuncios
    ADD CONSTRAINT fkrkl2ko7j5mxx8vp2r6xj167x FOREIGN KEY (venda_id) REFERENCES public.venda(id);


--
-- PostgreSQL database dump complete
--

