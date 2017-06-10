package com.djunderworld.nongjik.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProfessionalEntity is a Querydsl query type for ProfessionalEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProfessionalEntity extends EntityPathBase<ProfessionalEntity> {

    private static final long serialVersionUID = 1039209976L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfessionalEntity professionalEntity = new QProfessionalEntity("professionalEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

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

    public final QUserEntity userEntity;

    public QProfessionalEntity(String variable) {
        this(ProfessionalEntity.class, forVariable(variable), INITS);
    }

    public QProfessionalEntity(Path<? extends ProfessionalEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProfessionalEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProfessionalEntity(PathMetadata<?> metadata, PathInits inits) {
        this(ProfessionalEntity.class, metadata, inits);
    }

    public QProfessionalEntity(Class<? extends ProfessionalEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity"), inits.get("userEntity")) : null;
    }

}

