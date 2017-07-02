package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProfessional is a Querydsl query type for Professional
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProfessional extends EntityPathBase<Professional> {

    private static final long serialVersionUID = -876404299L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfessional professional = new QProfessional("professional");

    public final QBase _super = new QBase(this);

    public final StringPath address = createString("address");

    public final StringPath businessNo = createString("businessNo");

    //inherited
    public final StringPath createdAt = _super.createdAt;

    public final StringPath homepage = createString("homepage");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath intro = createString("intro");

    public final StringPath phone = createString("phone");

    public final StringPath postCode = createString("postCode");

    public final StringPath sido = createString("sido");

    public final StringPath sidoCode = createString("sidoCode");

    public final StringPath sigungu = createString("sigungu");

    public final StringPath sigunguCode = createString("sigunguCode");

    public final StringPath subAddress = createString("subAddress");

    //inherited
    public final StringPath updatedAt = _super.updatedAt;

    public final QUser user;

    public QProfessional(String variable) {
        this(Professional.class, forVariable(variable), INITS);
    }

    public QProfessional(Path<? extends Professional> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProfessional(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProfessional(PathMetadata<?> metadata, PathInits inits) {
        this(Professional.class, metadata, inits);
    }

    public QProfessional(Class<? extends Professional> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

