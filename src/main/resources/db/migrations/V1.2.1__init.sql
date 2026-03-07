SET search_path TO public;

CREATE TABLE IF NOT EXISTS public.etablissements (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS public.facultes (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS public.promotions (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS public.travail_pratiques (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    matiere VARCHAR(150) NOT NULL,
    file_content TEXT,
    promotion_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    etablissement_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_tp_promotion
        FOREIGN KEY (promotion_id)
        REFERENCES public.promotions(id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_tp_user
        FOREIGN KEY (user_id)
        REFERENCES public.users(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_tp_etablissement
        FOREIGN KEY (etablissement_id)
        REFERENCES public.etablissements(id)
        ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS public.questions (
    id BIGSERIAL PRIMARY KEY,
    travail_pratique_id BIGINT NOT NULL,
    title TEXT NOT NULL,
    point DOUBLE PRECISION DEFAULT 0,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_question_tp
        FOREIGN KEY (travail_pratique_id)
        REFERENCES public.travail_pratiques(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.question_options (
    id BIGSERIAL PRIMARY KEY,
    question_id BIGINT NOT NULL,
    option TEXT NOT NULL,
    is_valid BOOLEAN DEFAULT FALSE,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_option_question
        FOREIGN KEY (question_id)
        REFERENCES public.questions(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.question_ouvertes (
    id BIGSERIAL PRIMARY KEY,
    question_id BIGINT NOT NULL,
    title TEXT NOT NULL,
    file_content TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_question_ouverte
        FOREIGN KEY (question_id)
        REFERENCES public.questions(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.question_case_studys (
    id BIGSERIAL PRIMARY KEY,
    question_id BIGINT NOT NULL,
    title TEXT NOT NULL,
    file_content TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_case_study_question
        FOREIGN KEY (question_id)
        REFERENCES public.questions(id)
        ON DELETE CASCADE
);