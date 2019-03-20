CREATE TABLE banks (
    name character varying(49),
    id bigint NOT NULL
);

--
-- Name: branches; Type: TABLE; Schema: public; Owner: siva; Tablespace: 
--

CREATE TABLE branches (
    ifsc character varying(11) NOT NULL,
    bank_id bigint,
    branch character varying(74),
    address character varying(195),
    city character varying(50),
    district character varying(50),
    state character varying(26)
);


--
-- Name: bank_branches; Type: VIEW; Schema: public; Owner: siva
--

CREATE VIEW bank_branches AS
 SELECT branches.ifsc,
    branches.bank_id,
    branches.branch,
    branches.address,
    branches.city,
    branches.district,
    branches.state,
    banks.name AS bank_name
   FROM (branches
     JOIN banks ON ((branches.bank_id = banks.id)));

--
-- Name: banks_id_pkey; Type: CONSTRAINT; Schema: public; Owner: siva; Tablespace: 
--

ALTER TABLE ONLY banks
    ADD CONSTRAINT banks_id_pkey PRIMARY KEY (id);


--
-- Name: branches_ifsc_pkey; Type: CONSTRAINT; Schema: public; Owner: siva; Tablespace: 
--

ALTER TABLE ONLY branches
    ADD CONSTRAINT branches_ifsc_pkey PRIMARY KEY (ifsc);


--
-- Name: branches_banks_fkey; Type: FK CONSTRAINT; Schema: public; Owner: siva
--

ALTER TABLE ONLY branches
    ADD CONSTRAINT branches_banks_fkey FOREIGN KEY (bank_id) REFERENCES banks(id);


