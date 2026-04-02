SET search_path TO public;

CREATE TABLE IF NOT EXISTS public.domaine (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS public.type_documents (
    id BIGSERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS public.category_docs (
    id BIGSERIAL PRIMARY KEY,
    domaine_id BIGINT,
    name VARCHAR(150) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_category_doc_domaine
        FOREIGN KEY (domaine_id)
        REFERENCES public.domaine(id)
        ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS public.documents (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    type_document BIGINT NOT NULL,
    background_image TEXT,
    file_book TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    price BIGINT,
    devise BIGINT,
    is_premium BOOLEAN DEFAULT FALSE,
    date_publication TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_document_user
        FOREIGN KEY (user_id)
        REFERENCES public.users(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_document_type_document
        FOREIGN KEY (type_document)
        REFERENCES public.type_documents(id)
        ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS public.document_categories (
    id BIGSERIAL PRIMARY KEY,
    document_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,

    CONSTRAINT fk_document_category_document
        FOREIGN KEY (document_id)
        REFERENCES public.documents(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_document_category_category
        FOREIGN KEY (category_id)
        REFERENCES public.category_docs(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.favorite_documents (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    document_id BIGINT NOT NULL,
    is_like BOOLEAN DEFAULT TRUE,
    is_active BOOLEAN DEFAULT TRUE,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_favorite_document_document
        FOREIGN KEY (document_id)
        REFERENCES public.documents(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_favorite_document_user
        FOREIGN KEY (user_id)
        REFERENCES public.users(id)
        ON DELETE CASCADE,

    CONSTRAINT uq_favorite_document_user_document
        UNIQUE (document_id, user_id)
);

CREATE TABLE IF NOT EXISTS public.avis_documents (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    commentaire TEXT NOT NULL,
    cote BIGINT DEFAULT 3,
    is_active BOOLEAN DEFAULT TRUE,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_avis_document_user
        FOREIGN KEY (user_id)
        REFERENCES public.users(id)
        ON DELETE CASCADE
);
