import { Link } from "@heroui/link";
import { Snippet } from "@heroui/snippet";
import { Code } from "@heroui/code";
import { button as buttonStyles } from "@heroui/theme";

import { siteConfig } from "@/config/site";
import { title, subtitle } from "@/components/primitives";
import { GithubIcon } from "@/components/icons";

export default function Home() {
  return (
    <section className="flex flex-col items-center justify-center gap-4 py-8 md:py-10">
      <div className="inline-block max-w-xl text-center justify-center">
        
        <span className={title()}>
          Create, add, and modify your budget!
        </span>
        <div className={subtitle({ class: "mt-4" })}>
          Choose your options from below
        </div>
      </div>

      <div className="flex gap-3">
        <Link
          className={buttonStyles({
            color: "success",
            radius: "full",
            variant: "shadow",
          })}
          href="/add"
        >
          Add Budget
        </Link>
        <Link
          className={buttonStyles({
            color: "secondary",
            radius: "full",
            variant: "shadow",
          })}
          href="/modify"
        >
          Modify Budget
        </Link>
        <Link
          className={buttonStyles({
            color: "danger",
            radius: "full",
            variant: "shadow",
          })}
          href="/delete"
        >
          Delete Budget
        </Link>
        <Link
          className={buttonStyles({ variant: "bordered", radius: "full" })}
          href="/view_budget"
        >
          View Budget
        </Link>
      </div>

      
    </section>
  );
}
