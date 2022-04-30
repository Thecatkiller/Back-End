package com.opso.cheapshop.resource;

import com.opso.cheapshop.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResource extends AuditModel {
    private Long id;
    private String description;
}
